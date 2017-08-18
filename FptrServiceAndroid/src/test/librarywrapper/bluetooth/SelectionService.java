package test.librarywrapper.bluetooth;

import com.google.common.base.Converter;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SelectionService<X, T extends List<X>, A extends Converter<X, String>> {
    protected final T deviceList;
    protected final A converter;

    public SelectionService(T deviceList, A converter) {
        this.deviceList = deviceList;
        this.converter = converter;
    }

    public List<String> getSelectionList() {
        return newArrayList(converter.convertAll(deviceList));
    }

    public X getObject(String id) {
        for (X device : deviceList) {
            if (id.equals(converter.convert(device))) {
                return device;
            }
        }
        return null;
    }
}

