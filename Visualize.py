import numpy as np
import matplotlib.pyplot as plt
f = open("gametheory.txt", "r")
aaa=[]
bbb=[]
ccc=[]
ddd=[]
aa = f.readline().split()
bb = f.readline().split()
cc = f.readline().split()
dd = f.readline().split()
for i in range(5):
	aaa.append(float(aa[i]))
	bbb.append(float(bb[i]))
	ccc.append(float(cc[i]))
	ddd.append(float(dd[i]))

	
bcx = np.array(aaa)
#print(aa)
bcy = np.array(bbb)
bcxx = np.array(ccc)
bcyy = np.array(ddd)
#print(bb)
'''
bcx=np.array([0.2,1,1.2,1.4,2])
bcy=np.array([1,2,3,4,5])
bcxx=np.array([0.1,0.9,1.12,1.32,1.88])
bcyy=np.array([1,2,3,4,5])
'''
plt.plot(bcy,bcx,color="y")
plt.plot(bcyy,bcxx,color="r")
plt.scatter(bcy,bcx,color="b")
plt.scatter(bcyy,bcxx,color="y")
plt.show()