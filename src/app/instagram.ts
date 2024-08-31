export class Instagram {


    id: number = 0;
    imagePath: string = '';
    description: string = '';
    userId: number = 0;

    constructor(id: number, imagePath: string, description: string, userId: number) {
        this.id = id;
        this.imagePath = imagePath;
        this.description = description;
        this.userId = userId;
    }
}
