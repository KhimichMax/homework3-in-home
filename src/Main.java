import Manager.*;
import TodoList.Epic;
import TodoList.Subtask;
import TodoList.Task;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Task task1 = new Task("�������1", Status.NEW, "��������");
        Task task2 = new Task("�������2", Status.IN_PROGRESS, "��������");
        Epic epic1 = new Epic("����1", Status.NEW);
        Epic epic2 = new Epic("����2", Status.NEW);
        Subtask subtask1 = new Subtask("���������1", epic1);
        Subtask subtask1_2 = new Subtask("���������2", epic1);
        Subtask subtask2 = new Subtask("���������3", epic2);

        manager.addMainTask(task1);
        manager.addMainTask(task2);
        manager.addMainTask(epic1);
        manager.addMainTask(epic2);
        manager.addSubtask(epic1, subtask1);
        manager.addSubtask(epic1,subtask1_2);
        manager.addSubtask(epic2,subtask2);

        for (Map.Entry<Integer, Task> entry : manager.getAllTask().entrySet()) {
            System.out.println(entry.getValue().getName() + " " + entry.getValue().getStatus());
            if (entry.getValue() instanceof Epic) {
                System.out.println(manager.getSubtask((Epic) entry.getValue(), 5));
            }

        }

        // �������� �� ������ �������
        /*
        System.out.println(epic1.getStatus());

        manager.setDoneSubtask(subtask1);

        System.out.println(epic1.getStatus());

        manager.setDoneSubtask(subtask1_2);

        System.out.println(epic1.getStatus());
        */

        // ������� ������������ ������ ��� epic
        /*
        if (manager.removeIndexTask(1) == true) {
            System.out.println("������ �������");
        }else {
            System.out.println("������ �� ���� �������");
        }
        */

        // ������� ������������ ���������
        /*
        if (manager.removeIndexSubtask(epic1, 4) == true) {
            System.out.println("��������� �������");
        }else {
            System.out.println("��������� �� ���� �������");
        }*/


        // ������� ��� ����
        /*
        if (manager.removeAllTask() == false) {
            System.out.println("������ �������");
        }else {
            System.out.println("������ ������ ����");
        }
        */

        // ������� ������ ������
        /*
        manager.removeTasks();
        System.out.println(manager.getAllTask().isEmpty());
        */

        // ������� ������ epic
        /*
        manager.removeEpics();
        System.out.println(manager.getAllEpic().isEmpty());
        */

        // ������� ������ ���������
        /*
        manager.removeAllSubtask();
        */

    }

}
