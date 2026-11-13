variable "aws_region" {
  description = "Região AWS"
  type        = string
  default     = "us-east-1"
}

variable "project_name" {
  description = "Nome do projeto (usado em tags e nomes de recursos)"
  type        = string
  default     = "dynamo-demo"
}

variable "table_name" {
  description = "Nome da tabela DynamoDB"
  type        = string
  default     = "products"
}
