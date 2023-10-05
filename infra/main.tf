module "compute_instance" {
  source                  = "git@github.com:Saptaktdk/terraform-modules.git//compute_instance/static_external_ip"
  instance_name           = var.instance_name
  instance_machine_type   = var.instance_machine_type
  instance_region         = var.region
  instance_zone           = var.zone
  instance_project_id     = var.project_id
  instance_description    = var.instance_description
  instance_labels         = var.instance_labels
  instance_tags           = var.instance_tags
  boot_disk_image         = var.boot_disk_image
  boot_disk_size          = var.boot_disk_size
  boot_disk_type          = var.boot_disk_type
  boot_disk_name          = var.boot_disk_name
  vpc_name                = var.vpc_name
  static_ip_name          = var.static_ip_name
  metadata_startup_script = var.metadata_startup_script

}