import org.wasmer.Instance
import org.wasmer.exports.Function
import java.nio.file.Files
import java.nio.file.Paths


fun main(args: Array<String>) {
    // Read the WebAssembly bytes.
    val bytes = Files.readAllBytes(Paths.get("src/main/resources/wasm_test.wasm"))


    // Instantiate the WebAssembly module.
    val instance = Instance(bytes)

    // Declare the `sum` function, as a regular Java function.
    val greeting: Function = instance.exports.getFunction("greeting_info")

    // Call `sum`.
    val result = greeting.apply("Knut", 2)

    println("Result: $result")

    instance.close()
}
