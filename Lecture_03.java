public class Lecture_03 {
    public class List {
        Node head; // описывает начало нашего списка (односвязный)
        Node tail; // хвост, добавялем ссылку на предыдущую ноду (для двусвязного списка)
        
        // public void add(int value) { // метод добавления в конец связанного списка
        //     Node node = new Node(); // создаем новую ноду
        //     node.value = value; // присваиваем ей добавляемое значение
        //     if (head == null) { // проверяем, если головы нет, то 
        //         head = node; // голове присваиваем значение ноды
        //         tail = node; // и хвосту присваиваем так же значение ноды
        //     } else { // если нода существет, список не пустой, то
        //         tail.next = node; // берем текущий хвост и говорим, что его следующая нода равна нашей ноде
        //         node.previous = tail; // наша предыдущая нода начинает ссылаться на хвост
        //         tail = node; // и теперь обновляем значение хвоста
        //     } 
        // }

        // public void add (int value, Node node) { // добавление в середину связанного списка
        //     Node next = node.next; // то, на что ссылается нода в текущий момент
        //     Node newNode = new Node(); // так же создаем ноду
        //     newNode.value = value; // присваиваем значение ноды
        //     node.next = newNode; // берем текущую ноду и говорим, что ее следующее значение это новая нода
        //     newNode.previous = node; // предыдущее значение новой ноды, это нода
        //     if (next == null) { // делаем проверку хвоста, если следующее значение = null
        //         tail = newNode; // то хвост равен новой ноде
        //     } else { // в обратном случае
        //         next.previous = newNode; // меняем ссылки, предыдущее значение следующей ноды равно новой ноде
        //         newNode.next = next; // следующее значение новой ноды равно следующе ноды
        //     }
        // }

        // public void delete (Node node) { // метод удаления ноды
        //     Node previous = node.previouse; // создаем новую переменную со ссылкой на предыдущую ноду
        //     Node next = node.next; //создаем ноду некст со ссылкой на следующую ноду
        //     if (previous == null) { // обрабатываем случай, когда удаляемая нода является головой
        //         next.previous = null; // говорим, что предыдущее значение будет равно null
        //         head = next; // и голова станет node.next
        //     } else {
        //         if (next == null) {// обрабатываем случай, когда удаляемая нода равна хвосту
        //             previous.next = null; // у предыдущего значения, следующее значение равно null
        //             tail = previous; // и теперь хвост равен предыдущему значению
        //         } else {
        //             previous.next = next; // изменили ссылки, теперь предыдущая нода ссылается на следующую (не на текущую)
        //     next.previous = previous; // и ссылка следующей ноды на предыдущую ссылается на предыдущую (не на текущую)
        //     // тем самы мы убрали ссылки на текущую ноду, когда удаляемая нода в середине списка
        //         }
        //     }
        // }

        // public Node find(int value) { // метод будет искать ноду в нашем списке
        //     Node currentNode = head; // точка старта поиска - голова
        //     while (currentNode != null) { // пока нода существует
        //         if (currentNode.value == value) { // если нода найдена
        //             return currentNode; // вернуть ноду
        //         }
        //         currentNode = currentNode.next; // если нода не найдена, обновляем currentNode 
        //         // и переходим на следующую ноду
        //     }
        //     return null; // если ноду не нашли, возвращаем пустоту
        // } 

        // public void revert() { // разворот двусвязного списка
        //     Node currentNode = head; // создаем ноду и присваиваем значение головы
        //     while (currentNode != null) { // пока currentNode не равна пустоте
        //         Node next = currentNode.next; // создаем ноду next и присваиваем значение currentNode.next
        //         Node previous = currentNode.previous; // создаем ноду previous  и присваиваем значение currentNode.previous
        //         currentNode.next = previous; // далее меняем ссылки местами, ссылке на следующую присваиваем ссылку на предыдущую
        //         currentNode.previous = next; // а предыдущей присваиваем ссылку на следующую
        //         if (previous == null) { // и запускаем проверку на tail / head
        //             tail = currentNode;
        //         }
        //         if (next == null) { // если следующего значения нет, то это становится головой
        //             head = currentNode;
        //         }
        //         currentNode = next; // переходим на следующую ноду
        //     }
        // }

        // public void push(int value) { // метод положить в стек для односвязного списка
        //     Node node = new Node();
        //     node.value = value;
        //     node.next = head;
        //     head = node;            
        // }

        // public Integer pop(){ // метод извлечения из стека для односвязного списка LIFO
        //     Integer result = null;
        //     if (head != null) {
        //         result = head.value;
        //         head = head.next;
        //     }
        //     return result;
        // }

        public void push(int value) { // метод положить в кучу для двусвязного списка
            Node node = new Node();
            node.value = value;
            node.next = head;
            head.previous = node;
            head = node;            
        }

        public Integer peak(){ // метод извлечения из кучи FIFO
            Integer result = null; 
            if (tail != null) { // если хвост существует, то
                result = tail.value; // в result записываем значение хвоста
                tail.previous.next = null; // удаляем ссылку у предыдущего значения на следующее
                tail = tail.previous; // и переприсваиваем значение хвоста предыдущему значению
            }
            return result;
        }

        // public void revert(){ // для удобства сделали отдельный метод запуска приватного метода для односвязного списка
        //     if (head != null && head.next != null) { // проверка, запускаем метод если список не пустой ив нем более 1-го значения
        //     /*
        //     Обработка previouseNode
        //     Node temp = head;
        //     revert(head.next, head);
        //     temp.next = null;
        //     */

        //         revert(head.next, head);
        //     }
        // }
        // private public void revert(Node currentNode, Node previousNode){ // разворот односвязного списка
        //     if (currentNode.next == null) { // если мы дошли до последней ноды
        //         head = currentNode; // то последняя нода должна стать головой      
        //     } else { // если же есть следующая нода, то запускаем рекурсию
        //         revert(currentNode.next, currentNode); 
        //     }
        //     currentNode.next = previousNode;
        //     previousNode.next = null;
        // }

        public class Node{ // создаем класс Node
            int value; // говорим, что Node имеет какое-то значение
            // и может хранить только простые числа
            Node next; // есть ссылка на следующую ноду (односвязный список)
            // то есть описывает следующую ноду
            Node previous; // добавляем ссылку на предыдущую ноду, 
            //тем самым делаем двусвязный список
        }
    }
}
