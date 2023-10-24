package br.com.bytebank.modelo

class CalculadoraBonificacao {

    var total: Double = 0.0
        private set

    fun registra(funcionario: Any) {    //valor original é funcionario: Funcionario
//        val funcionarioNovo: Funcionario = funcionario as Funcionario
//        funcionario as Funcionario  //smartcast
        if(funcionario is Funcionario){            //aqui verifica e se é uma instancia de funcionario
            this.total += funcionario.bonificacao  //o funcionario faz cast automatico
        }

    }

}