#include<stdio.h>
#include<stdlib.h>

struct node{
    struct node *prev;
    int data;
    struct node *next;
};

void printList(struct node *head){
    struct node *temp = head;
    while(temp != NULL){
        printf("%d ", temp -> data);
        temp = temp -> next;
    }
    printf("\n");
}

void revPrintList(struct node *tail){
    struct node *temp = tail;
    while(temp != NULL){
        printf("%d ", temp -> data);
        temp = temp -> prev;
    }
    printf("\n");
}

void Deallocate(struct node *head){
    struct node *temp = head;
    struct node *hold;
    while(temp != NULL){
        hold = temp -> next;
        free(temp);
        temp = hold;
    }
}

struct node * getFirst(struct node *head, int value){
    struct node *temp = malloc(sizeof(struct node));
    temp -> data = value;
    temp -> prev = NULL;

    if(head == NULL){
        temp -> next = NULL;
    }
    else{
        temp -> next = head;
        head -> prev = temp;
    }

    return temp;
}

int main(){
    int choice, value;
    struct node *head = NULL, *tail = NULL;

    printf("1. add 2. display 3. exit\n");

    do{
        printf("Enter choice : ");
        scanf("%d",&choice);
        if(choice == 1){
            printf("Enter the value : ");
            scanf("%d",&value);
            if(head == NULL){
                head = getFirst(head, value);
                tail = head;
            }
            else{
                head = getFirst(head, value);
            }
        }
        else if(choice == 2){
            printList(head);
            revPrintList(tail);
        }
        else if(choice == 3){
            break;
        }
    }while(1);

    Deallocate(head);
}