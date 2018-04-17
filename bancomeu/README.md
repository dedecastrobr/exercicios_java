# Meu Banco

Este é o sistema de gestão bancária no que qual você deve trabalhar. A aplicação deve  manter um cadastro de clientes com suas respectivas contas correntes.
 
# Instruções
As atividades a serem desenvolvidas serão implementadas por vocês numa branch à parte, conforme as instruões iniciais dos exercícios. As respostas descritivas podem ser adicionadas ao final desde de Readme que pode ser editado no prpóprio Eclipse ou qualquer outro editor de textos.


# Tarefas

Você deve desenvolver as seguintes atividades:

* **Sistema de Menu:** Note que a aplicação tem um sistema genérico de menus, onde você pode criar menus apenas instanciando uma classe e passando os parâmetros desejados. Explique o funcionamento dessa classe e implmente todos os menus que você necessitar utilizando ela. A aplicação faz uso em parte dessa classe, mas precisa ser refatorada para que implemente para todas as funcionalidades desejadas.
* **Cadastro de clientes:** Implemente um cadastro de clientes com os atributos definidos na classse.
* **Cadastro de contas:** Implemente um cadastro de contas com os atributos definidos na classe. A conta deve **obrigatoriamente** pertencer à um cliente, então considere a possibilidade de **buscar** por um clientes antes de solicitar os dados da conta;
* **Defeito:** Existe um defeito de implementação na classe  Conta, no método de saque. Você é capaz de identificar o defeito? Caso sim, descreva o problema e implemente uma solução.
* **Transferência:** Implemente uma tranferência entre duas contas. Qual a mellhor maneira de implementar? Observe os métodos ja existentes na classe e utilize-os na sua solução.
* **Conta Especial:** Implemente uma nova categoria de conta chamada "especial". Essa categoria de conta possui um valor de limite a ser utilizado pelo cliente. Note que o limite deve ser considerado em operações de saque e transferência. No caso da falta de fundos, as contas especiais podem liberar crédito até o limite estabelecido na mesma.
