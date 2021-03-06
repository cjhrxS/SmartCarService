import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { OwnerCar } from './owner-car';
import { Observable, throwError } from 'rxjs';
import { VechicleInspection } from './vechicle-inspection';
import { catchError } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CarProfileService {

  
 constructor(private http: HttpClient) { }

  createCar(carProfile: OwnerCar, username: String): Observable<HttpResponse<OwnerCar>>{
   return this.http.put<OwnerCar>('api/car/?brand='+ carProfile.brand +'&model='+ carProfile.model +'&graduationyear=' + carProfile.graduationyear + '&number=' + carProfile.number + '&vin=' + carProfile.vin + '&username=' + username, carProfile, { observe: 'response' })
  .pipe(
    catchError(this.handleError)
  );
  }

 createInspection(carVechicleInspection: VechicleInspection, carVin: String): Observable<VechicleInspection>{
  console.log(carVechicleInspection.dateOfInspection, carVechicleInspection.mileageOfCar, carVin);
   return this.http.post <VechicleInspection>('api/inspection?dateOfInspection=' + carVechicleInspection.dateOfInspection + '&mileageOfCar=' + carVechicleInspection.mileageOfCar + '&vin=' + carVin, carVechicleInspection, httpOptions)
   .pipe(
    catchError(this.handleError)
  );
 }


 private handleError(error: HttpErrorResponse) {
  if (error.error instanceof ErrorEvent) {
    // A client-side or network error occurred. Handle it accordingly.
    console.error('An error occurred:', error.error.message);
  } else {
    // The backend returned an unsuccessful response code.
    // The response body may contain clues as to what went wrong,
    console.error(
      `Backend returned code ${error.status}, ` +
      `body was: ${error.error}`);
  }
  // return an observable with a user-facing error message
  return throwError(
    'Something bad happened; please try again later.');
};
}

