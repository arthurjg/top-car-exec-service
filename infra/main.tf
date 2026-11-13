resource "aws_dynamodb_table" "products" {
  name         = var.table_name
  billing_mode = "PAY_PER_REQUEST" # on-demand: sem capacidade para dimensionar
  hash_key     = "id"

  attribute {
    name = "id"
    type = "S"
  }

  point_in_time_recovery {
    enabled = true
  }

  server_side_encryption {
    enabled = true
  }
}

# Política com o mínimo de permissões que a aplicação precisa.
# Anexe a uma role (ECS/EKS/EC2/Lambda) ou a um usuário IAM de desenvolvimento.
data "aws_iam_policy_document" "app_dynamodb" {
  statement {
    effect = "Allow"
    actions = [
      "dynamodb:GetItem",
      "dynamodb:PutItem",
      "dynamodb:UpdateItem",
      "dynamodb:DeleteItem",
      "dynamodb:Scan",
      "dynamodb:Query",
    ]
    resources = [
      aws_dynamodb_table.products.arn,
      "${aws_dynamodb_table.products.arn}/index/*",
    ]
  }
}

resource "aws_iam_policy" "app_dynamodb" {
  name        = "${var.project_name}-dynamodb-access"
  description = "Acesso da aplicação à tabela ${var.table_name}"
  policy      = data.aws_iam_policy_document.app_dynamodb.json
}
