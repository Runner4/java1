package ru.progwards.pvv.lesson17;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

public class Lesson17test {
//    Укажите количество строк, которое будет выведено в результате выполнения фрагмента кода


    public static void filesTest() throws IOException {
        final Path dir = Paths.get("C:\\test\\");
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*[123]*");

        Files.walkFileTree(dir, Collections.emptySet(), 2, new SimpleFileVisitor() {
             // @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                if (pathMatcher.matches(dir.relativize(path)))
                    System.out.println(path);
                return FileVisitResult.CONTINUE;
            }

             //  @Override
            public FileVisitResult visitFileFailed(Path file, IOException e) {
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
