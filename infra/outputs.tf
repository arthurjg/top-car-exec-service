output "table_name" {
  value = aws_dynamodb_table.products.name
}

output "table_arn" {
  value = aws_dynamodb_table.products.arn
}

output "iam_policy_arn" {
  description = "Anexe esta policy à role/usuário que executa a aplicação"
  value       = aws_iam_policy.app_dynamodb.arn
}
