package com.cafe.manager.web;


import com.cafe.manager.domain.Product;
import com.cafe.manager.domain.Table;
import com.cafe.manager.domain.User;
import com.cafe.manager.dto.ProductDto;
import com.cafe.manager.dto.TableDto;
import com.cafe.manager.dto.UserDto;
import com.cafe.manager.service.ProductService;
import com.cafe.manager.service.TableService;
import com.cafe.manager.service.UserService;
import org.hibernate.validator.constraints.NotBlank;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/get")
    public UserDto getUser(@Valid @NotBlank @RequestParam("email") final String email) {
        final User user = userService.getByEmail(email);
        final UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    //    @PreAuthorize("hasAnyRole('MANAGER')")
    @PostMapping(value = "/register")
    public ResponseEntity<UserDto> register(@Valid @NotNull @RequestBody final UserDto creationUserDto) {
        final User creationUser = modelMapper.map(creationUserDto, User.class);
        final User user = userService.register(creationUser);
        final UserDto userDto = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(value = "/manager/addTable")
    public ResponseEntity<TableDto> addTable(@Valid @NotNull @RequestBody final TableDto creationTableDto) {
        final Table creationTable = modelMapper.map(creationTableDto, Table.class);
        final Table table = tableService.modify(creationTable);
        final TableDto tableDto = modelMapper.map(table, TableDto.class);
        return ResponseEntity.ok(tableDto);
    }

    @PostMapping(value = "/manager/addProduct")
    public ResponseEntity<ProductDto> addProduct(@Valid @NotNull @RequestBody final ProductDto creationProductDto) {
        final Product creationProduct = modelMapper.map(creationProductDto, Product.class);
        final Product product = productService.modify(creationProduct);
        final ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return ResponseEntity.ok(productDto);
    }

    @PostMapping(value = "/waiter/{waiterId}/assignTable/{tableId}")
    public void assignTableToWaiter(@PathVariable("waiterId") Optional<Long> waiterId, @PathVariable("tableId") Optional<Long> tableId) {
        if (waiterId.isPresent() && tableId.isPresent()) {
            final User user = userService.getById(waiterId.get());
            final Table table = tableService.getById(tableId.get());
            user.setTable(table);
            userService.modify(user);
        }
        return;
    }

}
