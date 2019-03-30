/**
 * @Author iyboklee (iyboklee@gmail.com)
 */
package com.github.iyboklee.core.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderClassName = "Builder")
public class Postcode {

    private String zonecode;
    private String postcode;
    private String sido;
    private String sigungu;
    private String sigunguCode;
    private String bcode;
    private String bname;
    private String bname1;
    private String bname2;
    private String hname;
    private String buildingCode;
    private String buildingName;
    private AddressType addressType;
    private String roadAddress;
    private String roadname;
    private String roadnameCode;
    private List<String> jibunAddresses;

    public boolean hasRoadAddress() {
        return StringUtils.isNotEmpty(roadAddress);
    }

    public boolean hasJibunAddress() {
        return jibunAddresses != null && jibunAddresses.size() > 0;
    }

    public boolean isEmpty() {
        return StringUtils.isEmpty(roadAddress) && !hasJibunAddress();
    }

    public String defaultJibunAddress() {
        return hasJibunAddress() ? jibunAddresses.get(0) : null;
    }

    public String availableAddress(AddressType addressType) {
        if (addressType == AddressType.R)
            return hasRoadAddress() ? roadAddress : defaultJibunAddress();

        return hasJibunAddress() ? defaultJibunAddress() : roadAddress;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Empty postcode";
        return availableAddress(AddressType.R);
    }

}