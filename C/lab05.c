#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#define LINESIZE 1024

int get_word(const char prompt[], char word[], size_t n);
int is_valid_id(const char s[]);
int get_int(const char prompt[], int *p);

int main(void) {

    char prompt1[] = "Enter the student ID: ";
    char prompt2[] = "Enter the grades of the student: ";
    size_t n = 10;
    char studentId[10];
    int grade = 0;
    int *gradeP = &grade;

    do {
        get_word(prompt1, studentId, n);
    } while (!is_valid_id(studentId));
    
    get_int(prompt2, gradeP);
    
    FILE *file = fopen("lab05.txt", "a");
    if (file == NULL) {
        printf("Error opening file!\n");
        exit(1);
    }
    
    fprintf(file, "%s %3d ", studentId, grade);
    
    fclose(file);


return 0;
}

/*
    If a word of length strictly less than n is successfully read from stdin, it is stored in the array word & the function return 1; if the user presses the end-of-file key, the function returns 0 (see details below) 
*/
int get_word(const char prompt[], char word[], size_t n) {
    char line[LINESIZE];
    char temp[LINESIZE];

    while(1) {
        printf("%s", prompt);
        if(!fgets(line, LINESIZE, stdin)) {
            clearerr(stdin);
            return 0;
        }
        if((sscanf(line, "%s", temp) == 1) && (strlen(temp) < n)) {
            strcpy(word, temp);
            return 1;
        }
    }

}

/*
    returns 1 if s is a valid ID; otherwise returns 0 (see details below)
*/
/*check the length
check the first char
check the 1-8*/
int is_valid_id(const char s[]) {
    
    int i = 0;

    if (strlen(s) != 9) {
        return 0;
    }
    
    if (s[0] != 'a' && s[0] != 'A') {
        return 0;
    }
    
    for (i = 1; i < 9; i++) {
        if (!isdigit(s[i])) {
            return 0;
        }
    }
    return 1;
}

/*
    if an integer is successfully read from stdin, it is passed back to the caller via the pointer p & the function returns 1; if the user presses the end-of-file key, the function returns 0
*/
int get_int(const char prompt[], int *p) {

    int temp = 0;

    char line[LINESIZE];
    while (1) {
        printf("%s", prompt);
        if(!fgets(line, LINESIZE, stdin)) {
            clearerr(stdin);
            return 0;
        }
        if((sscanf(line, "%d", &temp) == 1) 
            && (temp >= 0 && temp <= 100)) {
            *p = temp;
            return 1;
        }
    }    

}

