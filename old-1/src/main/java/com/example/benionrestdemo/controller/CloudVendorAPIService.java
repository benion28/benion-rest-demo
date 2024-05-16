package com.example.benionrestdemo.controller;

import com.example.benionrestdemo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    CloudVendor cloudVendor;

    @GetMapping
    public CloudVendor getCloudVendorDetails() {
        return cloudVendor;
//                new CloudVendor("C1", "Vendor 1", "Address One", "vendor-1-xxxx");
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetail(String vendorId) {
        return cloudVendor;
//                new CloudVendor("C1", "Vendor 1", "Address One", "vendor-1-xxxx");
    }

    @PostMapping
    public  String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor = cloudVendor;
        return  "Cloud Vendor Created Successfully";
    }

    @PutMapping
    public  String updateCloudVendorDetail(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor = cloudVendor;
        return  "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public  String deleteCloudVendorDetail(String vendorId) {
        this.cloudVendor = null;
        return  "Cloud Vendor Deleted Successfully";
    }
}
