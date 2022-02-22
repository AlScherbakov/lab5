package commander;

import util.*;

import java.util.*;

public class Invoker {
    private final Receiver state;
    static final ArrayList<CommandEnum> history = new ArrayList<>();
//    private Command addCommand;
//    private Command clearCommand;
//    private Command executeScriptCommand;
//    private Command exitCommand;
//    private Command filterLessThanSemesterEnumCommand;
//    private Command helpCommand;
//    private Command historyCommand;
//    private Command infoCommand;
//    private Command maxGroupByAdminCommand;
//    private Command printFieldDescendingGroupAdminCommand;
//    private Command removeByIdCommand;
//    private Command removeGreaterCommand;
//    private Command removeLowerCommand;
//    private Command saveCommand;
//    private Command showCommand;
//    private Command updateElementCommand;
//
//    private final HashMap<CommandEnum, Command> commandMap = new HashMap<>(){{
//        put(CommandEnum.ADD, addCommand);
//        put(CommandEnum.CLEAR, clearCommand);
//        put(CommandEnum.EXECUTE_SCRIPT, executeScriptCommand);
//        put(CommandEnum.EXIT, exitCommand);
//        put(CommandEnum.FILTER_LESS_THAN_SEMESTER_ENUM, filterLessThanSemesterEnumCommand);
//        put(CommandEnum.HELP, helpCommand);
//        put(CommandEnum.HISTORY, historyCommand);
//        put(CommandEnum.INFO, infoCommand);
//        put(CommandEnum.MAX_BY_GROUP_ADMIN, maxGroupByAdminCommand);
//        put(CommandEnum.PRINT_FIELD_DESCENDING_GROUP_ADMIN, printFieldDescendingGroupAdminCommand);
//        put(CommandEnum.REMOVE_BY_ID, removeByIdCommand);
//        put(CommandEnum.REMOVE_GREATER, removeGreaterCommand);
//        put(CommandEnum.REMOVE_LOWER, removeLowerCommand);
//        put(CommandEnum.SAVE, saveCommand);
//        put(CommandEnum.SHOW, showCommand);
//        put(CommandEnum.UPDATE, updateElementCommand);
//    }};

    public Invoker(Receiver programState){
        state = programState;
    }

    public Receiver executeCommand(String rawCommand){
        switch (rawCommand){
            case "help": {
//                helpCommand.execute();
                System.out.println(new HelpCommand().execute());
                history.add(CommandEnum.HELP);
                break;
            }
            case "info": {
                try {
//                    infoCommand.execute();
                    System.out.println(new InfoCommand(state.getCollection(), state.getCollectionInitializationDate()).execute());
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.INFO);
                }
                //вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                break;
            }
            case "show": {
                try {
//                    showCommand.execute();
                    System.out.println(new ShowCommand(state.getCollection()).execute());
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.SHOW);
                }
                //вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                break;
            }
            case "add": {
                try {
//                    addCommand.execute();
                    state.addToCollection(new AddElementCommand(state.getSource()).execute());
//                    new ShowCommand(state.getCollection()).execute();
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.ADD);
                }
                //добавить новый элемент в коллекцию {element}
                break;
            }
            case "clear": {
                try {
//                    clearCommand.execute();
                    state.setCollection(new ClearCommand().execute());
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.CLEAR);
                }
                //очистить коллекцию
                break;
            }
            case "save": {
                try {
//                    saveCommand.execute();
                    new SaveCommand(state.getOutputFilepath(), state.getCollection()).execute();
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.SAVE);
                }
                break;
            }
            case "exit": {
                try {
//                    exitCommand.execute();
                    new ExitCommand().execute();
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.EXIT);
                }
                //завершить программу (без сохранения в файл)
                break;
            }
            case "remove_greater": {
                try {
//                    removeGreaterCommand.execute();
                    state.setCollection(new RemoveGreaterCommand(state.getCollection(), state.getSource()).execute());
//                    new ShowCommand(state.getCollection()).execute();
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.REMOVE_GREATER);
                }
                //удалить из коллекции все элементы, превышающие заданный {element}
                break;
            }
            case "remove_lower": {
                try {
//                    removeLowerCommand.execute();
                    state.setCollection(new RemoveLowerCommand(state.getCollection(), state.getSource()).execute());
//                    new ShowCommand(state.getCollection()).execute();
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.REMOVE_LOWER);
                }
                break;
            }
            case "history": {
                try {
//                    historyCommand.execute();
                    ArrayList<CommandEnum> historyToShow = new HistoryCommand(history).execute();
                    historyToShow.forEach(System.out::println);
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.HISTORY);
                }
                //вывести последние 6 команд (без их аргументов)
                break;
            }
            case "max_by_group_admin": {
                try {
//                    maxGroupByAdminCommand.execute();
                    System.out.println(new MaxGroupByAdminCommand(state.getCollection()).execute());
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.MAX_BY_GROUP_ADMIN);
                }
                //вывести любой объект из коллекции, значение поля groupAdmin которого является максимальным
                break;
            }
            case "print_field_descending_group_admin": {
                try {
//                    printFieldDescendingGroupAdminCommand.execute();
                    System.out.println(new PrintFieldDescendingGroupAdminCommand(state.getCollection()).execute());
                } catch (Exception e){
                    System.out.println("Возникла ошибка. Попробуйте ещё раз");
                } finally {
                    history.add(CommandEnum.PRINT_FIELD_DESCENDING_GROUP_ADMIN);
                }
                //вывести значения поля groupAdmin всех элементов в порядке убывания
                break;
            }
            default: {
                if(rawCommand.matches("^update \\d+")){
                    try {
                        int id = Integer.parseInt(rawCommand.split(" ")[1]);
//                        updateElementCommand.execute();
                        state.setCollection(new UpdateElementCommand(id, state.getCollection(), state.getSource()).execute());
//                        new ShowCommand(state.getCollection()).execute();
                    } catch (Exception e){
                        System.out.println("Возникла ошибка. Попробуйте ещё раз");
                    } finally {
                        history.add(CommandEnum.UPDATE);
                    }
                    //обновить значение элемента коллекции, id которого равен заданному {element}
                } else if (rawCommand.matches("^remove_by_id \\d+")){
                    try{
                        int id = Integer.parseInt(rawCommand.split(" ")[1]);
//                        removeByIdCommand.execute();
                        state.setCollection(new RemoveByIdCommand(id, state.getCollection()).execute());
//                        new ShowCommand(state.getCollection()).execute();
                    } catch (Exception e){
                        System.out.println("Возникла ошибка. Попробуйте ещё раз");
                    } finally {
                        history.add(CommandEnum.REMOVE_BY_ID);
                    }
                    //удалить элемент из коллекции по его id
                } else if (rawCommand.matches("^execute_script .+")){//\w+\.\w+
                    try {
                        String scriptPath = rawCommand.split(" ")[1];
                        state.pushReader(new ExecuteScriptCommand(scriptPath).execute());
//                        ArrayList<String> commandStack = new ArrayList<>();
//                        state.setSource(new DataInputSource(br));
//                        runCommand(inputSource.get(), outputFilepath, gson, groups, history, working, collectionInitializationDate, inputMode, inputSource, scriptCommandStack);
//                        scriptCommandStack.add(1, commandStack);
//                        String scriptCommand = inputSource.get();
//                        while (!Objects.equals(scriptCommand, "")){
//                            runCommand(command, outputFilepath, gson, groups, history, working, collectionInitializationDate, inputMode, inputSource, scriptCommandStack);
//                            scriptCommand = inputSource.get();
//                        }
//                        String line = br.readLine();
//                        while (line != null){
//                            commandStack.add(line);
//                            line = br.readLine();
//                        }
//                        for(String c: commandStack){
//                            runCommand(c, outputFilepath, gson, groups, history, working, collectionInitializationDate);
//                        }
                    } catch (Exception e){
                        System.out.println("Возникла ошибка. Попробуйте ещё раз");
                    } finally {
                        history.add(CommandEnum.EXECUTE_SCRIPT);
                    }

                    // подменить стандартный поток ввода на поток данных из файла. Продумать execute_script в файле (рекурсия)
                    //считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                } else if (rawCommand.matches("^filter_less_than_semester_enum [A-Z]+")){
                    try {
                        Semester semesterEnum = Semester.valueOf(rawCommand.split(" ")[1]);
//                        filterLessThanSemesterEnumCommand.execute();
                        state.setCollection(new FilterLessThanSemesterEnumCommand(semesterEnum, state.getCollection()).execute());
//                        new ShowCommand(state.getCollection()).execute();
                    } catch (Exception e){
                        System.out.println("Возникла ошибка. Попробуйте ещё раз");
                    } finally {
                        history.add(CommandEnum.FILTER_LESS_THAN_SEMESTER_ENUM);
                    }
                    //вывести элементы, значение поля semesterEnum которых меньше заданного
                } else {
                    System.out.printf("Команды '%s' не существует (help - список команд) или аргумент команды не задан\n", rawCommand);
                }
                break;
            }
        }
//        commandMap.get(command.getName()).execute();
        state.setHistory(history);
        return state;
    }
//    public static Builder newBuilder(){
//        return new Builder();
//    }
//
//    public static class Builder {
//        private final Invoker newInvoker;
//
//        public Builder(){
//            newInvoker = new Invoker();
//        }
//        public Builder setAddCommand(Command c){
//            newInvoker.addCommand = c;
//            return this;
//        }
//        public Builder setClearCommand(Command c){
//            newInvoker.clearCommand = c;
//            return this;
//        }
//        public Builder setExecuteScriptCommand(Command c){
//            newInvoker.executeScriptCommand = c;
//            return this;
//        }
//        public Builder setExitCommand(Command c){
//            newInvoker.exitCommand = c;
//            return this;
//        }
//        public Builder setFilterLessThanSemesterEnumCommand(Command c){
//            newInvoker.filterLessThanSemesterEnumCommand = c;
//            return this;
//        }
//        public Builder setHelpCommand(Command c){
//            newInvoker.helpCommand = c;
//            return this;
//        }
//        public Builder setHistoryCommand(Command c){
//            newInvoker.historyCommand = c;
//            return this;
//        }
//        public Builder setInfoCommand(Command c){
//            newInvoker.infoCommand = c;
//            return this;
//        }
//        public Builder setMaxGroupByAdminCommand(Command c){
//            newInvoker.maxGroupByAdminCommand = c;
//            return this;
//        }
//        public Builder setPrintFieldDescendingGroupAdminCommand(Command c){
//            newInvoker.printFieldDescendingGroupAdminCommand = c;
//            return this;
//        }
//        public Builder setRemoveByIdCommand(Command c){
//            newInvoker.removeByIdCommand = c;
//            return this;
//        }
//        public Builder setRemoveGreaterCommand(Command c){
//            newInvoker.removeGreaterCommand = c;
//            return this;
//        }
//        public Builder setRemoveLowerCommand(Command c){
//            newInvoker.removeLowerCommand = c;
//            return this;
//        }
//        public Builder setSaveCommand(Command c){
//            newInvoker.saveCommand = c;
//            return this;
//        }
//        public Builder setShowCommand(Command c){
//            newInvoker.showCommand = c;
//            return this;
//        }
//        public Builder setUpdateElement(Command c){
//            newInvoker.updateElementCommand = c;
//            return this;
//        }
//        public Invoker build(){
//            return newInvoker;
//        }
//    }
}
