
package org.tondo.soap.client.cust;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="customerLevel"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ROOKIE"/&gt;
 *     &lt;enumeration value="PRO"/&gt;
 *     &lt;enumeration value="VETERAN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "customerLevel")
@XmlEnum
public enum CustomerLevel {

    ROOKIE,
    PRO,
    VETERAN;

    public String value() {
        return name();
    }

    public static CustomerLevel fromValue(String v) {
        return valueOf(v);
    }

}
