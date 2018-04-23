# Meu Banco

Este � o sistema de gest�o banc�ria no que qual voc� deve trabalhar. A aplica��o deve manter um cadastro de clientes com suas respectivas contas correntes.
 
# Instru��es
As atividades a serem desenvolvidas ser�o implementadas por voc�s numa branch � parte, conforme as instru��es iniciais dos exerc�cios. As respostas descritivas podem ser adicionadas ao final desde de Readme que pode ser editado no pr�prio Eclipse ou qualquer outro editor de textos.


# Tarefas

Voc� deve desenvolver as seguintes atividades:

* **Sistema de Menu:** Note que a aplica��o tem um sistema gen�rico de menus, onde voc� pode criar menus apenas instanciando uma classe e passando os par�metros desejados. Explique o funcionamento dessa classe e implemente todos os menus que voc� necessitar utilizando ela. A aplica��o faz uso em parte dessa classe, mas precisa ser refatorada para que implemente para todas as funcionalidades desejadas.
* **Cadastro de clientes:** Implemente um cadastro de clientes com os atributos definidos na classe.
* **Cadastro de contas:** Implemente um cadastro de contas com os atributos definidos na classe. A conta deve **obrigatoriamente** pertencer a um cliente, ent�o considere a possibilidade de **buscar** por um cliente antes de solicitar os dados da conta;
* **Defeito:** Existe um defeito de implementa��o na classe Conta, no m�todo de saque. Voc� � capaz de identificar o defeito? Caso sim, descreva o problema e implemente uma solu��o.
* **Transfer�ncia:** Implemente uma transfer�ncia entre duas contas. Qual a melhor maneira de implementar? Observe os m�todos j� existentes na classe e utilize-os na sua solu��o.
* **Conta Especial:** Implemente uma nova categoria de conta chamada "especial". Essa categoria de conta possui um valor de limite a ser utilizado pelo cliente. Note que o limite deve ser considerado em opera��es de saque e transfer�ncia. No caso da falta de fundos, as contas especiais podem liberar cr�dito at� o limite estabelecido na mesma.

--------------------------------------------------------------------------------

Nome: Henrique Rosa Carvalho
Turma: 421

Respostas:

- Sistema de Menu: na classe Menu, o m�todo show() serve para organizar os n�meros das op��es do menu principal e dos submenus dos clientes e das contas, e tamb�m imprimir �99 � Sair�. O m�todo getOption() armazena a op��o digitada pelo usu�rio e trata poss�veis erros de digita��o (letras ao inv�s de n�meros), e caso isto ocorra, imprime �Erro de valor! Somente n�meros!�.
