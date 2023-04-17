package com.app.Java.Dto;

import com.app.Java.Model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
  private Integer studentId;
  private Address address;
}
