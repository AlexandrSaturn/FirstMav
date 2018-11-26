package ForWork;

public class Repositor_array {
    private Person[] arr;

    Repositor_array(){arr=null;}

    public void add(Person p){
        if (arr==null) {
            arr = new Person[1];
            arr[0] = new Person(p);
        }
        else{
            Person[] new_arr = new Person[arr.length+1];

            for (int i=0;i<arr.length;i++)
                new_arr[i] = new Person(arr[i]);

            new_arr[arr.length] = new Person(p);


            arr=new_arr;
        }

    }

    public void println(){
        if (arr!=null)
        for (Person p1 : arr)
            p1.println();
    }

    public Person getPerson(int id){
        boolean search = false;
        int i=0;
        while (!search && i<arr.length){
            search = (arr[i].getId()==id);
            i++;
        }
        if (search)
            return arr[i-1];
        else
            return null;
    }

    private int getIndex(Person p){
        boolean search = false;
        int i=0;
        while (!search && i<arr.length){
            search = (arr[i].equals(p));
            i++;
        }
        if (search)
            return i-1;
        else
            return -1;
    }

    private int getIndex(int id){
        boolean search = false;
        int i=0;
        while (!search && i<arr.length){
            search = (arr[i].getId()==id);
            i++;
        }
        if (search)
            return i-1;
        else
            return -1;
    }




    public void deletePerson(int id){
        int index=getIndex(id);

        if (index>-1){
            Person[] new_arr = new Person[arr.length-1];
            for (int i=0;i<index;i++)
                new_arr[i] = new Person(arr[i]);

            for (int i=index+1;i<arr.length;i++)
                new_arr[i-1]= new Person(arr[i]);

            arr=new_arr;
        }

    }

    public void deletePerson(Person p){
        int index=getIndex(p);

        if (index>-1){
            Person[] new_arr = new Person[arr.length-1];
            for (int i=0;i<index;i++)
                new_arr[i] = new Person(arr[i]);

            for (int i=index+1;i<arr.length;i++)
                new_arr[i-1]= new Person(arr[i]);

            arr=new_arr;
        }

    }


}
