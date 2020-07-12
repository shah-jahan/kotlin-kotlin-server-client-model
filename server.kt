import java.io.BufferedInputStream
import java.net.ServerSocket
import java.io.DataInputStream
import java.io.IOException

fun main() {
    val server = ServerSocket(3030)
    val socket = server.accept()
    println("Connection established")
    while(true) {
 try {

     val input = DataInputStream(BufferedInputStream(socket.getInputStream()))

     var line = input.readUTF()

     if(line == "quit"){
         input.close()
         server.close()
         return
     }

     println("input recieved :: "+line)

    }
 catch (e: IOException){
     println(e)
 }
}
}