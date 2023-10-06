#? Login Credentials
variable "project_id" {
  type = string
}

variable "region" {
  type = string
}

variable "zone" {
  type = string
}

variable "service_account_json" {
  type = string
}

#? Module Variables
variable "instance_name" {
  type = string
}

variable "instance_machine_type" {
  type = string
}


variable "instance_description" {
  type = string
}

variable "instance_labels" {
  type = map(string)
}

variable "instance_tags" {
  type = list(string)
}

variable "boot_disk_image" {
  type = string
}

variable "boot_disk_size" {
  type = number
}

variable "boot_disk_type" {
  type = string
}

variable "boot_disk_name" {
  type = string
}

variable "vpc_name" {
  type = string
}

variable "vpc_project_id" {
  type = string
}

variable "vpc_subnet_name" {
  type = string
}

variable "static_ip_name" {
  type = string
}

variable "metadata_startup_script" {
  type = string
}