// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (val nome: String, val matricula: Int)

data class ConteudoEducacional(var nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }
    
    override fun toString(): String {
        return """
        $nome
        Nível $nivel
        ${conteudos.joinToString()}
        Alunos: ${inscritos}""".trimIndent()
    }
}

fun gerarMatricula(): Int {
    
    val matriculas = mutableListOf<Int>()
    var novaMatricula: Int
    
    do {
   		novaMatricula = (1000..10000).random()
	} while (novaMatricula in matriculas) 
    
    matriculas.add(novaMatricula)
    return novaMatricula
}

fun main() {
    
    val maria = Usuario("Maria", gerarMatricula())
    val pedro = Usuario("Pedro", gerarMatricula())
    val carla = Usuario("Carla", gerarMatricula())
    val jose = Usuario("José", gerarMatricula())
    val lucas = Usuario("Lucas", gerarMatricula())
    
    val caJava = ConteudoEducacional("Java", 45)
    val caSpring = ConteudoEducacional("Spring", 60)
    val caBancoDados = ConteudoEducacional("Banco de Dados", 90)
    val caHTML = ConteudoEducacional("HTML", 30)
    
    val formSpring = Formacao("Curso Spring Framework", Nivel.BASICO, listOf(caSpring))
    val formJava = Formacao("Curso Java", Nivel.INTERMEDIARIO, listOf(caJava))
    val formWeb = Formacao("Curso Desenvolvedor Web", Nivel.AVANCADO, listOf(caJava, caSpring, caBancoDados, caHTML))
    
    formSpring.matricular(maria, pedro)
    formJava.matricular(maria, carla, jose)
    formWeb.matricular(carla, jose, lucas)
    
    println(formSpring)
    println("\n----------------------\n")
    println(formJava)
    println("\n----------------------\n")
    println(formWeb)
    println("\n----------------------\n")
    
}
