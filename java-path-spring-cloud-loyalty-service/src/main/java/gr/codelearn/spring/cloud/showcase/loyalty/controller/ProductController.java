package gr.codelearn.spring.cloud.showcase.loyalty.controller;

import gr.codelearn.spring.cloud.showcase.loyalty.domain.Product;
import gr.codelearn.spring.cloud.showcase.loyalty.service.BaseService;
import gr.codelearn.spring.cloud.showcase.loyalty.service.ProductService;
import gr.codelearn.spring.cloud.showcase.loyalty.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController extends AbstractController<Product> {
	private final ProductService productService;

	@Override
	public BaseService<Product, Long> getBaseService() {
		return productService;
	}

	@GetMapping(params = {"serial"})
	public ResponseEntity<ApiResponse<Product>> findBySerial(@RequestParam(name = "serial") String serial) {
		return ResponseEntity.ok(ApiResponse.<Product>builder().data(productService.findBySerial(serial)).build());
	}
}