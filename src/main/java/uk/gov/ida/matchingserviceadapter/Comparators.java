package uk.gov.ida.matchingserviceadapter;

import uk.gov.ida.saml.core.domain.SimpleMdsValue;

import java.util.Comparator;

public class Comparators {
    public static <T> Comparator<SimpleMdsValue<T>> comparatorByVerified() {
        return Comparator.comparing(SimpleMdsValue::isVerified, Comparator.reverseOrder());
    }

    public static <T> Comparator<SimpleMdsValue<T>> comparatorByVerifiedThenCurrent() {
        Comparator<SimpleMdsValue<T>> isVerifiedComparator = comparatorByVerified();
        return isVerifiedComparator.thenComparing(SimpleMdsValue::getTo, Comparator.nullsFirst(null));
    }
}
