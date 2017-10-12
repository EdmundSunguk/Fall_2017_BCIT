#include <stdio.h>
#include <ctype.h>
#include <string.h>
#define LINESIZE 1024

int get_word(const char prompt[], char word[], size_t n);
int is_valid_id(const char s[]);
int get_int(const char prompt[], int *p);

int main(void) {

    char prompt[] = "Enter: ";
    size_t n = 9;
    char word[9];

    do {
        get_word(prompt, word, n);
    } while (is_valid_id(word) == 0);

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
        if((sscanf(line, "%s", temp)) == 1 && (strlen(temp) < n)) {
                strcpy(word, temp);
                /*printf("%s\n", word);*/
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
    size_t maxLength = 9;
    int boolean = 0;
    int i = 0;
    int length = strlen(s);

    if (strlen(s) == maxLength) {
        if (s[0] == 'A' || s[0] == 'a') {
            for (i = 1; i < length; i++) {
                if (isdigit(s[i])) {
                    boolean = 1;
                }
            }
        }
    }
    if (boolean) {
        printf("%s\n", s);
        return 1;
    } else {
        return 0;
    }
}

/*
    if an integer is successfully read from stdin, it is passed back to the caller via the pointer p & the function returns 1; if the user presses the end-of-file key, the function returns 0
*/
int get_int(const char prompt[], int *p) {

}
