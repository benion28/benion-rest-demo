package com.example.benionrestdemo.controller;

import com.example.benionrestdemo.model.CloudVendor;
import com.example.benionrestdemo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping
    public List<CloudVendor> getCloudVendorDetails() {
        return cloudVendorService.getAllCloudVendors();
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetail(@PathVariable("vendorId") String vendorId) {
        return cloudVendorService.getCloudVendor(vendorId);
    }

    @PostMapping
    public  String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping("{vendorId}")
    public  String updateCloudVendorDetail(@RequestBody CloudVendor cloudVendor, @PathVariable("vendorId") String vendorId) {
        cloudVendorService.updateCloudVendor(cloudVendor, vendorId);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public  String deleteCloudVendorDetail(@PathVariable("vendorId") String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}
