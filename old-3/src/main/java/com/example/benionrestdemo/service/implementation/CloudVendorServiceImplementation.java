package com.example.benionrestdemo.service.implementation;

import com.example.benionrestdemo.exception.CloudVendorNotFoundException;
import com.example.benionrestdemo.model.CloudVendor;
import com.example.benionrestdemo.repository.CloudVendorRepository;
import com.example.benionrestdemo.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImplementation implements CloudVendorService {

    @Autowired
    CloudVendorRepository cloudVendorRepository;

    public void setCloudVendorRepository(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor, String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Does Not Exist");
        CloudVendor updatedCloudVendor = cloudVendorRepository.findById(vendorId).get();
        updatedCloudVendor.setVendorAddress(cloudVendor.getVendorAddress());
        updatedCloudVendor.setVendorName(cloudVendor.getVendorName());
        updatedCloudVendor.setVendorPhoneNumber(cloudVendor.getVendorPhoneNumber());
        cloudVendorRepository.save(updatedCloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Does Not Exist");
        cloudVendorRepository.deleteById(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Does Not Exist");
        return cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
