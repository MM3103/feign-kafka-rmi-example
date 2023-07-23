package common.dto.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositePackage implements Package{

    private List<Package> packages = new ArrayList<Package>();

    @Override
    public void deliver() {
        for (Package pack: packages) {
            pack.deliver();
        }
    }

    public void add(Package pack) {
        packages.add(pack);
    }

    public void remove(Package pack) {
        packages.remove(pack);
    }
}
