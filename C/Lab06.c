#include <stdio.h>

/* pre-condition: n >= 1*/
void min_max(const int a[], size_t n, int *pmin, int *pmax) {
    size_t i = 0;
    *pmin = a[0];
    *pmax = a[0];

    for(int i = 0; i < n; i++) {
        if (a[i] < *pmin) {
            *pmin = a[i];
        }
        if (a[i] > *pmax) {
            *pmax = a[i];
        }
    }
}

unsigned num_digits(unsigned long n) {
    unsigned i = 10;
    unsigned counter = 1;
    while(n / i != 0) {
        i *= 10;
        counter++;
    }
    return counter;
}

/* pre-condition: n % 10 != 0 */
unsigned long reverse(unsigned long n) {
    unsigned numOfN = num_digits(n);
    unsigned tempReturn = 0;
    unsigned temp = 0;
    unsigned returnVal = 0;
    unsigned i = 10;
    float j = 10;
    unsigned forVal;
    /*initilizing j*/
    for (forVal = 0; forVal < (numOfN - 2); forVal++) {
        j *= 10;
    }
    for (forVal = 0; forVal < numOfN; forVal++) {
        temp = n % i;
        i *= 10;
        n = n - temp;
        tempReturn = temp * j;
        j *= 0.01;
        returnVal += tempReturn;
    }
    return returnVal;
}

int main(void) {

    int a[9] = {3, 4, 4, 1, 6, 7, 3, 5, 6};
    size_t n = 9;
    int min = 0;
    int max = 0;
    unsigned random1 = 43432;
    unsigned random2 = 123123123;
    unsigned random3 = 12345;

    min_max(a, n, &min, &max);
    printf("min: 1, max: 7\n");
    printf("%d %d", min, max);
    printf("\n");

    printf("%d %d\n", num_digits(random1), num_digits(random2));
    printf("%d", reverse(random3));

    return 1;
}
