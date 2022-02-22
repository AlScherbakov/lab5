package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Data collector class. Used for managing user input
 */
public class DataCollector {
    public DataInputModeEnum mode;
    public DataInputSource source;
//    private final Class<T> genericType;
    
    public DataCollector(DataInputModeEnum mode, DataInputSource source){
        this.mode = mode;
        this.source = source;
//        this.genericType = genericType;
    }

    public DataCollector(DataInputSource i) {
        source = i;
//        this.genericType = genericType;
    }

//    public T collect(String query, String p) {
//        try {
//            System.out.println(genericType.getName());
//            System.out.print(query);
//            String rawData = source.get();
//            Pattern pattern = Pattern.compile(p);
//            Matcher matcher = pattern.matcher(rawData);
//            if (matcher.find()) {
//                System.out.println(matcher.group(0));
//                switch (genericType.getName()){
//                    case "int":
//                    case "long":
//                    case "Integer":
//                    case "Long":
//                    case "java.time.LocalDate":
//                    case "java.lang.String": {
//                        return (T) matcher.group(0);
//                    }
//                    case "util.Color":
//                    case "util.Country":
//                    case "util.Semester": {
////                        assert genericType.isInstance(Enum.class);
//                        Method vo =  genericType.getDeclaredMethod("valueOf");
//                        return (T) vo.invoke(matcher.group(0));
//                    }
//                    case "util.Location": {
//                        Constructor<T> constructor = genericType.getConstructor(Double.class, Float.class, Integer.class, String.class);
//                        String[] params = matcher.group(0).split("\\s");
//                        return constructor.newInstance(Double.parseDouble(params[0]), Float.parseFloat(params[1]), Integer.parseInt(params[2]), params[3]);
//                    }
//                    case "util.Coordinates": {
//                        Constructor<T> constructor = genericType.getConstructor(Long.class, Double.class);
//                        String[] params = matcher.group(0).split("\\s");
//                        return constructor.newInstance(Long.parseLong(params[0]), Double.parseDouble(params[1]));
//                    } default: {
//                        return null;
//                    }
//                }
////                return (T) new parent(matcher.group(0));
//            } else {
//                return null;
//            }
////            List<String> data = List.of(matcher.group(1));
////            parent.getConstructor();
////        data.forEach(System.out::println);
////        return new parent(data);
//        } catch (Exception e){
//            return null;
//        }
//    };
//    private static final String personNameRegex = "([A-Z][a-z][А-ЯЁ][а-яё])+";
//    private static final String birthdayRegex = "\\d{2}.\\d{2}.\\d{4}";
//    private static final String colorRegex = "w+";
//    private static final String countryRegex = "w+";
//    private static final String locationRegex = ".+\\s.+\\s.+\\s.+";
//
//    private static final String groupNameRegex = "[A-Z]\\d{4,6}";
//    private static final String coordinatesRegex = ".+\\s.+";
//    private static final String studentsCountRegex = "\\d{1,}";
//    private static final String educationFormRegex = "w+";
//    private static final String semesterRegex = "w+";

    public Person requestPerson(){
        try{
//            String name = new DataCollector<String>(inputSource, String.class).collect( "Введите имя: ", personNameRegex);
//            LocalDate birthday = new DataCollector<LocalDate>(inputSource, LocalDate.class).collect( "Введите день рождения в формате дд.мм.гггг :", birthdayRegex);
//            Color eyeColor = new DataCollector<Color>(inputSource, Color.class).collect(String.format("Введите цвет глаз из доступных: (%s) ", Arrays.toString(Color.values())), colorRegex);
//            Country nationality = new DataCollector<Country>(inputSource, Country.class).collect(String.format("Введите национальность из доступных: (%s) ", Arrays.toString(Country.values())), countryRegex);
//            Location location = new DataCollector<Location>(inputSource, Location.class).collect("Введите локацию в формате (Double)x (Float)y (Integer)z (String)Название_локации: ", locationRegex);
            String name = collectName();
            LocalDate birthday = collectBirthday();
            Color eyeColor = collectEyeColor();
            Country nationality = collectNationality();
            Location location = collectLocation();
            return new Person(name, birthday, eyeColor, nationality, location);
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            requestPerson();
        }
        return null;
    };

    public StudyGroup requestStudyGroup(){
        try {
//            String name = new DataCollector<String>(inputSource, String.class).collect( "Введите имя группы в формате [A-Z]d{4,6}: ", groupNameRegex);
//            Coordinates coordinates = new DataCollector<Coordinates>(inputSource, Coordinates.class).collect( "Введите координаты в формате (Long)x (Double)y: ", coordinatesRegex);
//            int studentsCount = new DataCollector<Integer>(inputSource, int.class).collect("Введите количество студентов: ", studentsCountRegex);
//            long transferredStudents = new DataCollector<Long>(inputSource, long.class).collect("Введите Введите количество студентов по обмену: ", studentsCountRegex);
//            FormOfEducation formOfEducation = new DataCollector<FormOfEducation>(inputSource, FormOfEducation.class).collect(String.format("Введите форму обучения из доступных: (%s) ", Arrays.toString(FormOfEducation.values())), educationFormRegex);
//            Semester semesterEnum = new DataCollector<Semester>(inputSource, Semester.class).collect(String.format("Введите семестр из доступных: (%s) ", Arrays.toString(Semester.values())), semesterRegex);
//            System.out.println("Админ группы:");
//            Person groupAdmin = requestPerson(source);
            String name = collectName();
            Coordinates coordinates = collectCoordinates();
            int studentsCount = collectStudentsCount();
            long transferredStudents = collectTransferredStudents();
            FormOfEducation formOfEducation = collectFormOfEducation();
            Semester semesterEnum = collectSemesterEnum();
            System.out.println("Админ группы");
            Person groupAdmin = requestPerson();
            return new StudyGroup(name, coordinates, studentsCount, transferredStudents, formOfEducation, semesterEnum, groupAdmin);
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            requestStudyGroup();
        }
        return null;
    }


    private String collectName() {
        try {
            System.out.print("Введите имя:\t");
            if(source.hasNext()) {
    //            if (mode == DataInputModeEnum.EDIT) {
    //                System.out.printf("Введите новое имя (текущее имя: %s):\t", prevName);
    //            } else {
    //            }
                    return source.get();
            } else {
                return "Default name";
            }
        } catch (Exception e) {
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectName();
        }
    }
    private LocalDate collectBirthday() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            System.out.print("Введите день рождения в формате дд.мм.гггг:\t");
            if (source.hasNext()){
                String birthdayString = source.get();
    //            if (mode == DataInputModeEnum.EDIT){
    //                System.out.printf("Введите день рождения в формате дд.мм.гггг (текущее значение: %s):\t", prevValue.toString());
    //            } else {
    //            }
                    return LocalDate.parse(birthdayString, formatter);
            } else {
//                return LocalDate.parse(String.format("%d.%d.%d", Math.floor(Math.random() * 31), (int) Math.floor(Math.random() * 13), (int) Math.floor(Math.random() * 2000) ), formatter);
                return LocalDate.parse("20.01.2004", formatter);
            }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectBirthday();
        }

    }
    private Color collectEyeColor() {
        try {
            String colors = " ";
            for (Color color : Color.values()) {
                colors += color.toString() + " ";
            }
    //            if (mode == DataInputModeEnum.EDIT){
    //                System.out.printf("Введите цвет глаз из доступных (текущее значение: %s): (" + colors + ")\t", prevValue);
    //            } else {
            System.out.print("Введите цвет глаз из доступных: (" + colors + ")\t");
    //            }
            if (source.hasNext()){
                String eyeColorString = source.get();
                return Color.valueOf(eyeColorString);
            } else {
                return Color.values()[(int) Math.floor(Math.random() * Color.values().length)];
            }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectEyeColor();
        }

    }
    private Country collectNationality() {
        try {
            String nationalities = " ";
            for (Country country : Country.values()) {
                nationalities += country.toString() + " ";
            }
            System.out.print("Введите национальность из доступных: (" + nationalities + ")\t");
        if (source.hasNext()){
            String nationalityString = source.get();
//            if (mode == DataInputModeEnum.EDIT){
//                System.out.printf("Введите национальность из доступных (текущее значение: %s): (" + nationalities + ")\t", prevValue);
//            } else {
//            }
                return Country.valueOf(nationalityString);
        } else {
            return Country.values()[(int) Math.floor(Math.random() * Country.values().length)];
        }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectNationality();
        }

    }
    private Location collectLocation() {
        try {
            System.out.print("Введите локацию в формате (Double)x (Float)y (Integer)z название_локации:\t");
            if (source.hasNext()){
                String locationData = source.get();
                //            if (mode == DataInputModeEnum.EDIT){
    //                System.out.printf("Введите локацию (текущее значение: %.5f %.5f %d %s) в формате (Double)x (Float)y (Integer)z название_локации:\t", prevValue.getX(), prevValue.getY(), prevValue.getZ(), prevValue.getName());
    //            } else {
    //            }
                    String[] locationDataArray = locationData.split(" ");
                    Double x = Double.parseDouble(locationDataArray[0]);
                    Float y = Float.parseFloat(locationDataArray[1]);
                    Integer z = Integer.parseInt(locationDataArray[2]);
                    String locationName = locationDataArray[3];
                    return new Location(x, y, z, locationName);
            } else {
                return  new Location(10.0, (float) 10, 10, "Default location");
            }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectLocation();
        }
    }
    private Coordinates collectCoordinates() {
        try {
            System.out.print("Введите координаты в формате (Long)x (Double)y:\t");
            if (source.hasNext()){
                String coordinatesData = source.get();
                //            if (mode == DataInputModeEnum.EDIT){
        //                System.out.printf("Введите координаты (текущее значение: %d, %.5f) в формате (Long)x (Double)y:\t", prevCoordinates.getX(), prevCoordinates.getY());
        //            } else {
        //            }
                    String[] coordinatesDataArray = coordinatesData.split(" ");
                    long x = Long.parseLong(coordinatesDataArray[0]);
                    double y = Double.parseDouble(coordinatesDataArray[1]);
                    return new Coordinates(x, y);
            } else {
                return  new Coordinates(0,0);
            }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectCoordinates();
        }
    }
    private int collectStudentsCount() {
        try {
            System.out.print("Введите количество студентов:\t");
            if (source.hasNext()){
                String studentsCountString = source.get();
                //            if (mode == DataInputModeEnum.EDIT){
    //                System.out.printf("Введите новое количество студентов (текущее количество: %d):\t", prevCount);
    //            } else{
    //            }
                    return Integer.parseInt(studentsCountString);
            } else {
                return 20;
            }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectStudentsCount();
        }
    }
    private long collectTransferredStudents() {
        try {
            System.out.print("Введите количество студентов по обмену:\t");
            if (source.hasNext()){
                String transferredStudentsString = source.get();
                //            if (mode == DataInputModeEnum.EDIT){
    //                System.out.printf("Введите новое количество студентов по обмену (текущее количество: %d):\t", prevCount);
    //            } else {
    //            }
                    return Long.parseLong(transferredStudentsString);
            } else {
                return 1;
            }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectTransferredStudents();
        }
    }
    private FormOfEducation collectFormOfEducation() {
        try {
            String forms = " ";
            for (FormOfEducation form : FormOfEducation.values()) {
                forms += form.toString() + " ";
            }
            //            if (mode == DataInputModeEnum.EDIT){
            //                System.out.printf("Введите форму обучения из доступных (текущее значение %s): (" + forms + ")\t", prevValue);
            //            } else {
            System.out.print("Введите форму обучения из доступных: (" + forms + ")\t");
            //            }
            if (source.hasNext()){
                String formString = source.get();
                return FormOfEducation.valueOf(formString);
            } else {
                return FormOfEducation.values()[(int) Math.floor(Math.random() * FormOfEducation.values().length)];
            }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectFormOfEducation();
        }
    }
    private Semester collectSemesterEnum() {
        try {
            String semesters = " ";
            for (Semester semester : Semester.values()) {
                semesters += semester.toString() + " ";
            }
//            if (mode == DataInputModeEnum.EDIT){
//                System.out.printf("Введите семестр из доступных (текущее значение: %s): (" + semesters + ")\t", prevValue);
//            } else {
            System.out.print("Введите семестр из доступных: (" + semesters + ")\t");
//            }
            if (source.hasNext()){
                String semesterString = source.get();
                return Semester.valueOf(semesterString);
            } else {
                return Semester.values()[(int) Math.floor(Math.random() * Semester.values().length)];
            }
        } catch (Exception e){
            System.out.println("Возникла ошибка. Повторите ввод");
            return collectSemesterEnum();
        }
    }
}
