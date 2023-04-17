package com.platformCommons.dto;

import com.platformCommons.model.Address;

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
