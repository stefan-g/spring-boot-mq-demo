### Install rabbitMq
https://www.rabbitmq.com/docs/install-windows-manual
Erlang is required (https://erlang.org/download/otp_versions_tree.html). 

enable stream plugin
rabbitmq-plugins.bat enable rabbitmq_stream

RabbitMq is started by the rabbitmq-server.bat script in sbin.

### Enable management ui
rabbitmq-plugins.bat enable rabbitmq_management

Ui is accessable under: http://localhost:15672/. authentication is guest/guest


