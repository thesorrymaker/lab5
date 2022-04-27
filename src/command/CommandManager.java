package command;

import CSV.CSVReader;
import CSV.CSVWriter;
import collection.*;
import Tools.Tools;
import java.io.*;
import java.util.*;

/**
 * command manager
 */
public class CommandManager {
  public CommandManager(){
    commands.add(new Add());
    commands.add(new Addifmin());
    commands.add(new Average());
    commands.add(new Clear());
    commands.add(new ExecuteScript());
    commands.add(new Exit());
    commands.add(new Help());
    commands.add(new History());
    commands.add(new Info());
    commands.add(new Print());
    commands.add(new RemoveByld());
    commands.add(new RemoveGreater());
    commands.add(new Save());
    commands.add(new Show());
    commands.add(new UpdateID());
  }

  private int ScriptProtect=0;
  private static LinkedHashSet<AbstractCommand> commands=new LinkedHashSet<>();
  private boolean findid=false;

  /**
   * get static LinkedHashSet<AbstrcteCommand> commands
   * @return LinkedHashSet
   */
  public LinkedHashSet getCommands() {
    return this.commands;
  }

  /**
   * use Iterator to read LinkedHashSet<AbstractCommand> commands,and print all helps
   */
  public void executeHelp() {
    Iterator<AbstractCommand> iterator = commands.iterator();
    while (iterator.hasNext()) {
      AbstractCommand A = iterator.next();
      System.out.print(A.getName() + ":" + A.getHelp() + "\n");
    }
  }

  /**
   * user set and add a new object with the help of static method {@link Vehicle#VehicleCreate()} Create()}
   * @param vehicle
   * @throws ValueTooBigException
   * @throws ValueTooSmallException
   * @throws NullException
   */
  public void executeAdd(Vehicle vehicle) throws ValueTooBigException,ValueTooSmallException,NullException{
    new CollectionsofVehicle().doInitialization();
    new CollectionsofVehicle().getVehicle().add(vehicle);
  }

  /**
   * If user set a person smaller than him, add the new person
   * @param p
   */
  public void executeAddifmin(Vehicle p) {
    boolean judge=true;
    Iterator<Vehicle> iterator=new CollectionsofVehicle().getVehicle().iterator();
    while(iterator.hasNext()){
      if(p.compareTo(iterator.next())==1){
        judge=false;
      }
    }
    if(judge==true){
      new CollectionsofVehicle().getVehicle().add(p);
    }
  }

  /**
   * print the average of height
   */
  public void executeAverage() {
    Iterator<Vehicle> iterator=new CollectionsofVehicle().getVehicle().iterator();
    if(iterator.hasNext()) {
      float Total = 0;
      while (iterator.hasNext()) {
        Total = Total + iterator.next().getenginePower();
      }
      System.out.print(Total / (new CollectionsofVehicle().getVehicle().size()) + "\n");
    }else{
      throw new NullException("collections of Vehicle still empty\n");
    }
  }

  /**
   * clear all elements in collections
   */
  public void executeClear() {
    new CollectionsofVehicle().getVehicle().clear();
  }

  /**
   * exit the program
   */
  public void executeExit() {
    System.exit(2);
  }

  /**
   * print the information of collection(type,amount of elements,when it is created)
   */
  public void executeInfo() {
    if(!CollectionsofVehicle.Initialization){
      throw new NotInitializationException("collections was initialized");
    }else {
      System.out.print("the date of initialization is "+new CollectionsofVehicle().getInitializationTime()+"\n");
    }
    System.out.print("the amount of elements is "+ new CollectionsofVehicle().getVehicle().size()+"\n");
    System.out.print("the type of collection is "+ new CollectionsofVehicle().getVehicle().getClass() +"\n");
  }

  /**
   * print all the elements
   * When collections is empty,throw NullException
   *
   *
   * @throws NullException
   */
  public void executePrint() throws NullException{
    if(new CollectionsofVehicle().getVehicle().size()==0){
      System.out.print("collections still empty\n");
    }else {
      Integer[] list = getValues();
      int[] values = new int[list.length];
      for (int i = 0; i < values.length; i++) {
        values[i] = list[i];
      }
      Arrays.sort(values);
      for (int i = 0; i < values.length; i++) {
        findByLocationHash(values[i]);
      }
    }
  }
  /**
   * get the location of all people
   * @return
   */
  private LinkedHashSet<Coordinates> getLocations(){
    LinkedHashSet<Coordinates> linkedHashSet=new LinkedHashSet<>();
    Iterator<Vehicle> iterator=new CollectionsofVehicle().getVehicle().iterator();
    while(iterator.hasNext()){
      linkedHashSet.add(iterator.next().getCoordinates());
    }
    return linkedHashSet;
  }
  /**
   * return the values(hashcode) of all locations
   * {@link CommandManager#getLocations()}
   * @return Integer[]
   */
  private Integer[] getValues(){
    LinkedHashSet<Integer> arrayList=new LinkedHashSet<>();
    Iterator<Coordinates> iterator=getLocations().iterator();
    while(iterator.hasNext()){
      arrayList.add(iterator.next().hashCode());
    }
    Integer []list=arrayList.toArray(new Integer[arrayList.size()]);
    return list;
  }
  /**
   * print the location with specified hashcode
   * @param value
   */
  private void findByLocationHash(Integer value){
    Coordinates location;
    Coordinates print;
    Iterator<Vehicle> iterator=new CollectionsofVehicle().getVehicle().iterator();
    out:while (iterator.hasNext()){
      if((location=iterator.next().getCoordinates()).hashCode()==value){
        print=location;
        System.out.print(print.toString()+"\n");
        break out;
      }
    }
  }



  public void executeRemoveById(Integer id) {
    Vehicle p=findByid(id);
    if(findid==false){
      throw new ParalnapproException("no such a person with this id\n");
    }
    findid=false;
    new CollectionsofVehicle().getVehicle().remove(p);
  }

  /**
   * return person with specified id
   * @param id
   * @return Vehicle
   */
  private Vehicle findByid(Integer id){
    Vehicle p=null;
    Vehicle m;
    Iterator<Vehicle> iterator=new CollectionsofVehicle().getVehicle().iterator();
    out:while(iterator.hasNext()){
      if((m = iterator.next()).getId().equals(id)){
        p=m;
        findid=true;
        break out;
      }
    }
    return p;
  }

  /**
   * remove person with specified eye color
   * {@link CommandManager#findbyFuel} (String)}
   * @param fuel
   */
  public void executeRemoveEyeColor(String fuel){
    for(Vehicle p:findbyFuel(fuel)) {
      new CollectionsofVehicle().getVehicle().remove(p);
    }
  }

  /**
   * find person with Specified eye color
   * @param fuel
   * @return
   */
  private LinkedHashSet<Vehicle> findbyFuel(String fuel){
    LinkedHashSet<Vehicle> linkedHashSet=new LinkedHashSet<>();
    Vehicle A;
    FuelType fuelType=FuelType.valueOf(fuel);
    Iterator<Vehicle> iterator=new CollectionsofVehicle().getVehicle().iterator();
    while(iterator.hasNext()){
      if((A=iterator.next()).getFuelType()==fuelType){
        linkedHashSet.add(A);
      }
    }
    return linkedHashSet;
  }

  /**
   * Remove all the people,whose if bigger than specified
   * {@link CommandManager#findByid(Integer)}
   * @param in
   * @throws NullException
   */
  public void executeRemoveGreater(Integer in) throws NullException{
    Vehicle B=findByid(Integer.valueOf(in));
    if(B==null){
      throw new NullException("No element is available");
    }else {
      Vehicle p;
      Iterator<Vehicle> iterator=new CollectionsofVehicle().getVehicle().iterator();
      while(iterator.hasNext()){
        if((p=iterator.next()).compareTo(B)==1){
          new CollectionsofVehicle().getVehicle().remove(p);
        }
      }
    }
  }

  /**
   * write static LinkedHashSet in format csv
   * {@link CSVWriter#WriterToFile(LinkedHashSet, String)}
   * @throws IOException
   */
  public void executeSave(String path) throws IOException {
    LinkedHashSet <Vehicle> linkedHashSet=new CollectionsofVehicle().getVehicle();
    new CSVWriter().WriterToFile(linkedHashSet,path);
  }

  /**
   * print all the elements
   */
  public void executeShow() {
    if(new CollectionsofVehicle().getVehicle().size()==0){
      System.out.print("collections of vehicle still empty\n");
    }else{
      new Tools().PrintVehicleSet(new CollectionsofVehicle().getVehicle());
    }
  }

  /**
   * reset element with specified id.
   * {@link CommandManager#findByid(Integer)}
   * @param
   * @throws ParalnapproException
   */
  public void executeUpdateID(String in) throws ParalnapproException {
    Integer id=Integer.valueOf(in);
    Vehicle p;
    Iterator<Vehicle> iterator=new CollectionsofVehicle().getVehicle().iterator();
    out:while(iterator.hasNext()){
      if(findByid(id)==null){
        throw new ParalnapproException("no such a id\n");
      }
      if((p=iterator.next()).getId()==id){
        new CollectionsofVehicle().getVehicle().remove(p);
        Vehicle insert=Vehicle.VehicleCreate();
        insert.changeId(id);
        Vehicle.balaceicode();
        new CollectionsofVehicle().getVehicle().add(insert);
        break out;
      }
    }
  }

  /**
   * print the last 7 commands
   */
  public void executeHistory() {
    int size=new History().getHistory().size();
    Iterator<String> iterator=new History().getHistory().iterator();
    if (new History().getHistory().size() > 7) {
      while (size > 7) {
        iterator.next();
        size--;
      }
    }
    while(iterator.hasNext()){
      System.out.print(iterator.next());
    }
  }

  /**
   * Execute the command written in file
   * {@link CommandManager#findCommand(String)}
   * @param name
   * @throws IOException
   * @throws ParalnapproException
   */
  public void executeExecuteScript(String name,CommandManager commandManager,String Saver) throws IOException, ParalnapproException {
    FileReader f=new FileReader(new File(name));
    BufferedReader bufferedReader=new BufferedReader(f);
    String commandtext="";
    while((commandtext=bufferedReader.readLine())!=null){
      String []split=commandtext.split(" ");
      AbstractCommand command=findCommand(split[0]);
      if(command!=null&&!(command.getName().equals("ExecuteScript")&&split[1].equals(name))) {
        command.execute(commandManager, split,Saver);
        new History().getHistory().add(command.getName() + "\n");
      }
    }
    bufferedReader.close();
  }

  /**
   * find the command with specified name
   * @param name
   * @return
   */
  public AbstractCommand findCommand(String name){
    AbstractCommand A=null;
    AbstractCommand B;
    Iterator<AbstractCommand> iterator=commands.iterator();
    while(iterator.hasNext()){
      if((B=iterator.next()).getName().equalsIgnoreCase(name)) {
        A = B;
      }
    }
    return A;
  }


  public Vehicle findMin() {
    return null;
  }
}



