package Data;

import Commands.ExcpetionsCommand.NullException;
import Commands.ExcpetionsCommand.ValueTooBigException;
import Commands.ExcpetionsCommand.ValueTooSmallException;
import Data.DataException.NoSuchCountry;
import Data.DataException.NoSuchDifficulty;
import Data.DataException.NoSuchEyeColor;
import Data.DataException.NoSuchHairColor;
import Tools.StringTool;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

public class LabWork implements Serializable {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Double minimalPoint;
    private Difficulty difficulty;
    private Person author;

    public LabWork(String name, Coordinates coordinates, double minimalPoint, Difficulty difficulty, Person author) {
        this.id = generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.minimalPoint = minimalPoint;
        this.difficulty = difficulty;
        this.author = author;

    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getMinimalPoint() {
        return minimalPoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Person getAuthor() {
        return author;
    }

    public void changeId(Integer id) { this.id = id;}

    //@Override
    public int compareTo(LabWork labObj) {
        return id.compareTo(labObj.getId());
    }

    @Override
    public String toString() {
        String info = "";
        info += "Лаба №" + id;
        info += "(добавлен " + creationDate.toLocalDate() + " " + creationDate.toLocalTime() + ")";
        info += "\n Имя: " +name;
        info += "\n Местоположение: " + coordinates;
        info += "\n Минимальная оценка: " + minimalPoint;
        info += "\n Сложность: " + difficulty;
        info += "\n Автор: " + author;
        return info;
    }

    @Override
    public int hashCode() {
        int MinimalPoint = (int) Math.round(minimalPoint);
        return name.hashCode() + coordinates.hashCode() + MinimalPoint + difficulty.hashCode() + author.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof LabWork) {
            LabWork labObj = (LabWork) obj;
            return name.equals(labObj.getName()) && coordinates.equals(labObj.getCoordinates()) && (minimalPoint == labObj.getMinimalPoint()) && (difficulty == labObj.getDifficulty()) && author.equals(labObj.getAuthor());

        }
        return false;
    }

    public static int generateId(){
        Random r = new Random();
        Integer randomVal = Math.abs(r.nextInt());
        return randomVal;
    }


    public static LabWork LabWorkCreate() throws NullException, ValueTooSmallException, ValueTooBigException {

        System.out.print("Please enter name");
        Long x;
        double y;
        String name;
        double minimalPoint;
        Difficulty difficulty;
        String pname;
        Double pweight;
        Color eyeColor;
        hairColor hairColor;
        Country nationality;
        Long lx;
        double ly;
        String lname;

        System.out.println("Please enter name");
        while (true) {
            try {
                name = StringTool.Input();
                if (name == null) {
                    throw new NullException("Print Something");
                }
                break;
            } catch (NullException ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter x-coordinate");
        while (true) {
            try {
                String sx = StringTool.Input();
                x = Long.parseLong(sx);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter y-coordinate");
        while (true) {
            try {
                String sy = StringTool.Input();
                y = Double.parseDouble(sy);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter minimal point");
        while (true) {
            try {
                String mP = StringTool.Input();
                minimalPoint = Double.valueOf(mP);
                if (minimalPoint < 0) {
                    throw new ValueTooSmallException(" should be bigger than 0\n");
                }
                break;
            } catch (ValueTooSmallException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter something");
            }
        }

        System.out.println("Please enter difficulty level");
        while (true) {
            try {
                String df = StringTool.Input();
                df = df.toUpperCase();
                if (!Difficulty.nameList().contains(df)){
                    throw new NoSuchDifficulty("no such difficulty\n");
                }
                difficulty = Difficulty.valueOf(df);
                break;
        }catch (NoSuchDifficulty ex) {
                System.out.print(ex.getMessage());
            }

    }

        System.out.println("Please enter person's name");
        while (true) {
            try {
                pname = StringTool.Input();
                if (pname == null){
                    throw new NullException("Print Something");
                }break;
            }catch (NullException ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter person's weight");
        while (true) {
            try {
                String pw = StringTool.Input();
                pweight = Double.parseDouble(pw);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter eye color");
        while (true) {
            try {
                String ec = StringTool.Input();
                ec = ec.toUpperCase();
                if (!Color.nameList().contains(ec)){
                    throw new NoSuchEyeColor("no such eye color\n");
                }
                eyeColor = Color.valueOf(ec);
                break;
            }catch (NoSuchEyeColor ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter hair color");
        while (true) {
            try{
                String hc = StringTool.Input();
                hc = hc.toUpperCase();
                if (!Data.hairColor.nameList().contains(hc)){
                    throw new NoSuchHairColor ("no such hair color\n");
                }
                hairColor = Data.hairColor.valueOf(hc);
                break;
            }catch (NoSuchHairColor ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter country");
        while (true) {
            try{
                String c = StringTool.Input();
                c = c.toUpperCase();
                if (!Country.nameList().contains(c)){
                    throw new NoSuchCountry("no such country\n");
                }
                nationality = Country.valueOf(c);
                break;
            }catch (NoSuchCountry ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter location x-coordinate");
        while (true) {
            try {
                String locx = StringTool.Input();
                lx = Long.parseLong(locx);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter location y-coordinate");
        while (true) {
            try {
                String locy = StringTool.Input();
                ly = Double.parseDouble(locy);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter location name");
        while (true) {
            try {
                lname = StringTool.Input();
                if (lname.length()>838) {
                    throw new ValueTooBigException("too long");}
                if (lname == null) { throw new NullException("Print Something");}
                break;
                }catch (ValueTooBigException ex) {System.out.println(ex.getMessage());}
                 catch (NullException ex) {System.out.print(ex.getMessage());}
            }

        Coordinates coordinates = new Coordinates(x,y);
        Location location = new Location(lx,ly,lname);
        Person author = new Person(pname, pweight,eyeColor, hairColor, nationality,location);

       return new LabWork(name, coordinates, minimalPoint, difficulty, author);
        }
    }

