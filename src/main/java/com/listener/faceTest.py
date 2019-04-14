# coding:utf-8
import face_recognition

#输入已知图片biden.jpg
known_image = face_recognition.load_image_file("biden.jpg")
#输入待识别的图片unknown.jpg
unknown_image = face_recognition.load_image_file("unknown.jpg")

biden_encoding = face_recognition.face_encodings(known_image)[0]
unknown_encoding = face_recognition.face_encodings(unknown_image)[0]

results = face_recognition.compare_faces([biden_encoding], unknown_encoding)
print(results)