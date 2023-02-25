package pro.sky.hw24.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pro.sky.hw24.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping
    public String helloCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public ResponseEntity<?> plusCalculator(@RequestParam(required = false, name = "num1") Integer num1,
                                            @RequestParam(required = false, name = "num2") Integer num2) {
        if (num1 != null && num2 != null) {
            CalculatorService plus = new CalculatorService();
            return ResponseEntity.ok().body(num1 + " + " + num2 + " = " + plus.plus(num1, num2));
        } else {
            return new ResponseEntity<>("Необходимо ввести оба числа", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/minus")
    public ResponseEntity<?> minusCalculator(@RequestParam(required = false, name = "num1") Integer num1,
                                            @RequestParam(required = false, name = "num2") Integer num2) {
        if (num1 != null && num2 != null) {
            CalculatorService minus = new CalculatorService();
            return ResponseEntity.ok().body(num1 + " - " + num2 + " = " + minus.minus(num1, num2));
        } else {
            return new ResponseEntity<>("Необходимо ввести оба числа", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/multiply")
    public ResponseEntity<?> multiplyCalculator(@RequestParam(required = false, name = "num1") Integer num1,
                                             @RequestParam(required = false, name = "num2") Integer num2) {
        if (num1 != null && num2 != null) {
            CalculatorService multiply = new CalculatorService();
            return ResponseEntity.ok().body(num1 + " * " + num2 + " = " + multiply.multiply(num1, num2));
        } else {
            return new ResponseEntity<>("Необходимо ввести оба числа", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divideCalculator(@RequestParam(required = false, name = "num1") Double num1,
                                                @RequestParam(required = false, name = "num2") Double num2) {
        if (num1 != null && num2 != null) {
            if (num2 == 0) {
                return new ResponseEntity<>("Делить на ноль нельзя", HttpStatus.NOT_FOUND);
            }
            CalculatorService divide = new CalculatorService();
            return ResponseEntity.ok().body(num1 + " / " + num2 + " = " + divide.divide(num1, num2));
        } else {
            return new ResponseEntity<>("Необходимо ввести оба числа", HttpStatus.NOT_FOUND);
        }
    }
}
