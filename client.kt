import java.io.DataOutputStream
import java.net.Socket
import java.net.ConnectException

fun main() {
    lateinit var socket :Socket
    var p = true
    try {
         socket = Socket("127.0.01", 3030)
    }
    catch (e:ConnectException){
        println("no service found")
        return
    }
        val pw = DataOutputStream(socket.getOutputStream());
    while (p) {
        var line = readLine()

        pw.writeUTF(line)
        pw.flush()

        //close connection
        if (line.equals("quit")) {
            pw.close()
            socket.close()
            p=false
        }
    }
}