package JavaExtractor.FeaturesEntities;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProgramFeatures {
    String name;

    transient ArrayList<ProgramRelation> features = new ArrayList<>();
    String textContent;

    String filePath;
    String qualifiedName;

    public ProgramFeatures(String name, Path filePath, String textContent, String qualifiedName) {

        this.name = name;
        this.filePath = filePath.toAbsolutePath().toString();
        this.textContent = textContent;
        this.qualifiedName = qualifiedName;
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(qualifiedName).append(" ");
        stringBuilder.append(name).append(" ");
        stringBuilder.append(features.stream().map(ProgramRelation::toString).collect(Collectors.joining(" ")));

        return stringBuilder.toString();
    }

    public void addFeature(Property source, String path, Property target) {
        ProgramRelation newRelation = new ProgramRelation(source, target, path);
        features.add(newRelation);
    }

    public boolean isEmpty() {
        return features.isEmpty();
    }
}
