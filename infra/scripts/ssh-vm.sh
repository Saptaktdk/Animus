#!/bin/bash

VM_EXTERNAL_IP="34.28.16.52"
RUNNER_PRIVATE_KEY_PATH=/home/saptak/.ssh/runner
GITHUB_PRIVATE_KEY_PATH=/home/saptak/.ssh/github
USER_NAME=runner

#? SSH into the VM
eval `ssh-agent`

scp -i $RUNNER_PRIVATE_KEY_PATH $GITHUB_PRIVATE_KEY_PATH $USER_NAME@$VM_EXTERNAL_IP:/home/$USER_NAME/.ssh/id_ed25519

ssh-add $PRIVATE_KEY_PATH

ssh -i $RUNNER_PRIVATE_KEY_PATH $USER_NAME@$VM_EXTERNAL_IP 

