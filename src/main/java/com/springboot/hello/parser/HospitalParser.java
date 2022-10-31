package com.springboot.hello.parser;

import com.springboot.hello.domain.dto.Hospital;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HospitalParser implements Parser<Hospital> {
    @Override
    public Hospital parse(String str){
//        1, hospital.getId());
//        "의원", hospital.getOpenServiceName());
//        3620000, hospital.getOpenLocalGovernmentCode());
//        "PHMA119993620020041100004", hospital.getManagementNumber());
//        LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate()); //19990612
//        6, hospital.getBusinessStatus());
//        13, hospital.getBusinessStatusCode());
//        "062-515-2875", hospital.getPhone());
//        "광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress());
//        "광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());
//        "효치과의원", hospital.getHospitalName());
//        "치과의원", hospital.getBusinessTypeName());
//        1, hospital.getHealthcareProviderCount());
//        0, hospital.getPatientRoomCount());
//        0, hospital.getTotalNumberOfBeds());
//        52.29, hospital.getTotalAreaSize());
             String[] row = str.split("\",\"");
             System.out.println(Arrays.toString(row));

             Hospital hospital = new Hospital();
            hospital.setId(Integer.parseInt(row[0].replace("\"","")));
            hospital.setOpenServiceName(row[1]);
        hospital.setOpenLocalGovernmentCode(Integer.parseInt(row[3]));
        hospital.setManagementNumber(row[4]);

        int year = Integer.parseInt(row[5].substring(0,4));
        int month = Integer.parseInt(row[5].substring(4,6));
        int day = Integer.parseInt(row[5].substring(6,7));
//        System.out.printf("%d %d %d \n",year,month,day);
        hospital.setLicenseDate(LocalDateTime.of(year, month, day, 0, 0, 0));







        return new Hospital();
        }
    }

