data class laptop(val brand: String, val price:Int, val age:Int){

    fun show(){
        println("hello main")
    }
}
fun main(args: Array<String>){

    val lap1= laptop("dell", 3000, 30)

    val lap2=laptop("apple", 400, 40)

    val lap3=lap2.copy()

    println(lap1.component3())
}