package com.umermansoor.trafficdistributor.util;

/**
 * This class is used for representing a network end-point.
 * Thread-Safe: Immutable.
 * Safe to use in a container that relies on the hashcode.
 * @author umer
 */
public class Host {

    private final String hostname;
    private final int port;

    /**
     * Constructor
     * @param hostname
     * @param port
     */
    public Host(String hostname, int port) {

        if (hostname == null) {
            throw new NullPointerException("host cannot be null.");
        }

        if (hostname.length() > 255 || hostname.length() < 1) {
            throw new IllegalArgumentException("hostname must be 1 to 255 characters long.");
        }

        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("port  must be between 1 and 65535");
        }

        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return hostname + ":" + port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Host == false) {
            return false;
        }

        Host otherHost = (Host)obj;

        if (otherHost.hostname == hostname && otherHost.port == port) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 17 + hostname.hashCode() + port;
    }
}