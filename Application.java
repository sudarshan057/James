 name: Update web servers
  hosts: webservers
  remote_user: root

  tasks:
  - name: Ensure apache is at the latest version
    ansible.builtin.yum:
      name: httpd
      state: latest

  - name: Write the apache config file
    ansible.builtin.template:
      src: /srv/httpd.j2
      dest: /etc/httpd.conf

- name: Update db servers
  hosts: databases
  remote_user: root

  tasks:
  - name: Ensure postgresql is at the latest version
    ansible.builtin.yum:
      name: postgresql
      state: latest

#feature202 changes done by james in july 2024
Playbook syntax

Playbook execution

Task execution

Desired state and ‘idempotency’

Running playbooks

Running playbooks in check mode

Ansible-Pull

Verifying playbooks

ansible-lint
=======
#feature201 changed by james in july 2024
ansible-lint
Learn how to test Ansible Playbooks syntax

YAML Syntax
Learn about YAML syntax

General tips
Tips for managing playbooks in the real world

Collection Index
Browse existing collections, modules, and plugins

Should you develop a module?
Learn to extend Ansible by writing your own modules

Patterns: targeting hosts and groups
Learn about how to select hosts

GitHub examples directory
Complete end-to-end playbook examples

Mailing List
Questions? Help? Ideas? Stop by the list on Google Groups.
#End of feature201 code.


  - name: Ensure that postgresql is started
    ansible.builtin.service:
      name: postgresql
      state: started