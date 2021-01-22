package chapter_001.io;
//1. При запуске указывается папка, которую мы хотим архивировать, например: c:\project\job4j\
//2. В качестве ключа передается  расширения файлов, которые не нужно включать в архив.
//3. Архив должен сохранять структуру проекта. То есть содержать подпапки.
//4. Запуск проекта.
//-d=c:\project -e*=java -o=project.zip
//java -jar pack.jar - Это собранный jar.
//
//-d - directory - которую мы хотим архивировать
//-e - exclude - исключить файлы *.xml
//-o - output - во что мы архивируем.

public class ArgZip {
    private final String[] args;
    private ArgsName argsName;

    public ArgZip(String[] args) {
        this.args = args;
        if (valid()) {
            this.argsName = ArgsName.of(args);

        }
    }

    public boolean valid() {
        return args.length >= 3;
    }

    public String directory() {
        return argsName.get("-d");
    }

    public String exclude() {
        return argsName.get("-e");
    }

    public String output() {
        return argsName.get("-o") ;
    }
}
