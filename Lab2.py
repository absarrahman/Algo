#merge sort
def mergeSort(arr):
  if(len(arr)>1):
    mid=len(arr)/2
    mid=int(mid)
    leftArray=arr[:mid] # 0 to mid
    rightArray=arr[mid:] # mid to last index
    mergeSort(leftArray)
    mergeSort(rightArray)
    i=0 # left
    j=0 # right
    c=0

    while(i<(len(leftArray)) and j<(len(rightArray))):
      if(leftArray[i]<rightArray[j]):
        arr[c]=leftArray[i]
        i+=1
      else:
        arr[c]=rightArray[j]
        j+=1
      c+=1

    while(i<len(leftArray)):
      arr[c]=leftArray[i]
      c+=1
      i+=1

    while(j<len(rightArray)):
      arr[c]=rightArray[j]
      c+=1
      j+=1

#quickSort partition
def partition(arr,p,q): #p is pivot
  x=arr[p]
  i=p
  for j in range(p+1,q+1):
    if arr[j]<=x:
      i=i+1
      arr[i],arr[j]=arr[j],arr[i]
  arr[p],arr[i]=arr[i],arr[p]
  return i

#quicksort
def quickSort(arr,p,r):
  if p<r:
    q=partition(arr,p,r)
    quickSort(arr,p,q-1)
    quickSort(arr,q+1,r)

#insertition sort
def insertitionSort(arr,n):
  for j in range(2,n+1):
    val=arr[j]
    i=j-1
    while((i>0) and (arr[i]>val)):
      arr[i+1]=arr[i]
      i=i-1
    arr[i+1]=val

#main
print("Task 1")
arr=[3, 5 , 10, 23, 25, 8, 7, 9, 50, 47]
print(arr)
print("Merge Sort")
mergeSort(arr)
print(arr)
print("Task 2")
arr=[3, 5 , 10, 23, 25, 8, 7, 9, 50, 47]
print(arr)
print("Quick Sort")
quickSort(arr,0,(len(arr)-1))
print(arr)
print("Task 3")
arr=[3, 5 , 10, 23, 25, 8, 7, 9, 50, 47]
print(arr)
print("Insertition Sort")
insertitionSort(arr,(len(arr)-1))
print(arr)