package nl.idgis.demo

import java.math.BigInteger

import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.stereotype.Controller
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@Controller
class MyController {

	companion object {
		
		private const val LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n"
	}
	
	@ResponseBody
	@GetMapping("/greeting")
	fun sayHello() = "Hello, world!"
	
	@ResponseBody
	@GetMapping("/fibonacci/{n}")
	fun calcFibonacci(@PathVariable n: BigInteger): BigInteger {
		var current = BigInteger.ZERO
		var next = BigInteger.ONE
		
		var count = n
		while (count != BigInteger.ZERO) {
			val tmp = current + next
			current = next
			next = tmp
			count--
		}
	
		return current
	}
	
	@ResponseBody
	@GetMapping("/loremipsum")
	fun repeatloremIpsum(@RequestParam n: Int?): CharSequence {
		val sb = StringBuilder()
	
		for (i in 0..(n ?: 42)) {
			sb.append(LOREM_IPSUM)
		}
		
		return sb
	}
}

@SpringBootApplication
class DemoAppApplication

fun main(args: Array<String>) {
	runApplication<DemoAppApplication>(*args)
}
