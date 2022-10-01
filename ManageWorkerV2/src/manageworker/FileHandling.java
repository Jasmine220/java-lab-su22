package manageworker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import manageworker.Worker;

public class FileHandling {

    public static void writeToFileWorker(List<Worker> listWorker) throws FileNotFoundException {
        try {
            File fileWork = new File("workers.dat");
            //check if file existed
            if (!fileWork.exists()) {
                fileWork.createNewFile();
            }
            //dữ liệu mới ghi vào file sẽ được ghi tiếp vào cuối file
            FileOutputStream fos = new FileOutputStream("workers.dat", true);
            //dùng để mã hoá các đối tượng java
            //Lớp ObjectOutputStream chỉ ghi những đối tượng implelements Serializable interface
            //(Serialization, Java object sẽ được chuyển đổi qua byte streams)
            ObjectOutputStream os = new ObjectOutputStream(fos);
            //loop use to access from first element to last element of list
            for (int i = 0; i < listWorker.size(); i++) {
                os.writeObject(listWorker.get(i));
            }
            os.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Can't write to file");
        }
    }

    public static void readFromFileWorker(List<Worker> list) {
        try {
            FileInputStream fis = new FileInputStream("workers.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //loop use to acceses from first element to last element of list
            for (int i = 0; i < list.size(); i++) {
                Worker worker = (Worker) ois.readObject();
                list.add(worker);
            }
            ois.close();
            fis.close();
        } catch (Exception e) {
        }
    }

    public static void writeToFileHisWorker(List<HistoryWorker> listHisWorker) throws FileNotFoundException {
        try {
            File fileWork = new File("hisWorkers.dat");
            //check if file existed
            if (!fileWork.exists()) {
                fileWork.createNewFile();
            }
            //dữ liệu mới ghi vào file sẽ được ghi tiếp vào cuối file
            FileOutputStream fos = new FileOutputStream(fileWork, true);
            //dùng để mã hoá các đối tượng java
            //Lớp ObjectOutputStream chỉ ghi những đối tượng implelements Serializable interface
            //(Serialization, Java objectsẽ được chuyển đổi qua byte streams)
            ObjectOutputStream os = new ObjectOutputStream(fos);
            //loop use to access from first element to last element of list
            for (int i = 0; i < listHisWorker.size(); i++) {
                os.writeObject(listHisWorker.get(i));
            }
            os.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Can't write to file");
        }
    }

    public static void readFromFileHisWorker(List<HistoryWorker> listHisWorker) {
        try {
            FileInputStream fis = new FileInputStream("hisWorkers.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //loop use to acceses from first element to last element of list
            for (int i = 0; i < listHisWorker.size(); i++) {
                HistoryWorker hisWorker = (HistoryWorker) ois.readObject();
                listHisWorker.add(hisWorker);
            }
            ois.close();
            fis.close();
        } catch (Exception e) {
        }
    }

}
