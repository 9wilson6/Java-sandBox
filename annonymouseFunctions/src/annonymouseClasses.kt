interface Human{
    fun think()
}

fun main(args: Array<String>){
    var wilson: Human= object: Human{
        override fun think(){
            println("Plis enter your name below")
            var name:String?= readLine();
            print("my name is $name")
        }
    }
    wilson.think()
}