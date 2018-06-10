package com.ds.subway.sandwich.common;

import org.apache.commons.lang3.StringUtils;

public enum Style implements Printable {

    ITALIAN,
    INDIAN,
    ENGLISH,
    AMERICAN;

    @Override
    public String print() {
	return StringUtils.join(toString(), " Style");
    }

}
