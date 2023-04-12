package org.utils;

public class VersionHolder {
    protected static int version;

    public VersionHolder(int version) {
        this.version = version+1;
    }

    public int getVersion() {
        return version;
    }
}
