#include <stdlib.h>
#include <stddef.h>
#include <stdio.h>
#include <string.h>


int gt_int(int *a, int *b) {
    return (*a >= *b);
}

int gt_char(char *a, char *b) {
    return (*a >= *b);
}

int gt_str(char** a, char** b) {
    if (strcmp(*a, *b) >= 0) return 1;
    return 0;
}

const void* mymax(
  const void *base, size_t nmemb, size_t size,
  int (*compar)(const void *, const void *)) {
	void* max = base;
      for (int i = 0; i < nmemb ; i++) 
        if ( compar((base + i*size), max))
             max = (base + i*size);
    
      return max;

  }

int main() {
    int arr_int[] = { 1, 3, 5, 7, 4, 6, 9, 2, 0 };
    int* max_int = (int*) mymax((const void*) arr_int, sizeof(arr_int) / sizeof(int), sizeof(int), (int (*)(const void *, const void *)) &gt_int);
    printf("max int: %d\n", *max_int);

    char arr_char[]="Suncana strana ulice";
    char* max_char = (char*) mymax((const void*) arr_char, strlen(arr_char), sizeof(char), (int (*)(const void *, const void *)) &gt_char);
    printf("max char: %c\n", *max_char);

    const char* arr_str[] = {
   "Gle", "malu", "vocku", "poslije", "kise",
   "Puna", "je", "kapi", "pa", "ih", "njise"
    };
    char** max_str = (char*) mymax((const void**) arr_str, sizeof(arr_str) / sizeof(char*), sizeof(char*), (int (*)(const void *, const void *)) &gt_str);


    printf("max string: %s\n", *max_str );

}
